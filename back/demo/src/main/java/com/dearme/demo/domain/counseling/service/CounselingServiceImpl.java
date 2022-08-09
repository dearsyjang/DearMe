package com.dearme.demo.domain.counseling.service;

import com.dearme.demo.domain.counseling.dto.CounselingInfoListResponseDto;
import com.dearme.demo.domain.counseling.dto.CounselingInfoResponseDto;
import com.dearme.demo.domain.counseling.dto.UpdateCounselingRequestDto;
import com.dearme.demo.domain.counseling.dto.UpdateCounselingResponseDto;
import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Status;
import com.dearme.demo.domain.counseling.exception.NoExistCounselingException;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.global.scheduler.CounselJob;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CounselingServiceImpl implements CounselingService{
    private final CounselingRepository counselingRepository;

    private final UserRepository userRepository;

    @Override
    public void createCounseling(CounselingDocument counselingDocument) {
        Counseling counseling = counselingDocument.toCounselingEntity();
        counseling.setCounselingDocument(counselingDocument);
        counselingRepository.save(counseling);

        createScheduler(counseling);
    }

    @Override
    public CounselingInfoListResponseDto getCounselings(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        List<Counseling> counselings = null;
        if(user.getType().equals(Type.USER))
            counselings = counselingRepository.findAllByUser_Id(id);
        else
            counselings = counselingRepository.findAllByCounselor_Id(id);
        List<CounselingInfoResponseDto> counselingInfoResponseDtos = new ArrayList<>();
        for(Counseling counseling : counselings){
            counselingInfoResponseDtos.add(CounselingInfoResponseDto.of(counseling));
        }
        return new CounselingInfoListResponseDto(counselingInfoResponseDtos);
    }

    @Override
    public void createGroupCounseling(CounselingDocument counselingDocument) {
        Counseling counseling = counselingDocument.toGroupCounselingEntity();
        counseling.setCounselingDocument(counselingDocument);
        counselingRepository.save(counseling);
    }

    @Override
    public UpdateCounselingResponseDto updateCounseling(String id, UpdateCounselingRequestDto dto) {
        Counseling target = counselingRepository.findCounselingByCounselor_IdAndId(id, dto.getId()).orElseThrow(() -> {
            throw new NoExistCounselingException();
        });
        if(dto.getStatus().equals(Status.REJECT)){
            counselingRepository.delete(target);
        }else {
            target.updateCounseling(dto.getStatus());
            counselingRepository.save(target);
        }
        return null;
    }

    public void createScheduler(Counseling counseling){
        try {
            // Scheduler 사용을 위한 인스턴스화
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            // JOB Data 객체
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("nickName", counseling.getCounselor().getNickName());
            jobDataMap.put("date", counseling.getYear()+"." + counseling.getMonth()+"."+counseling.getDay()+" " + counseling.getHours()+"시");
            JobDetail jobDetail = JobBuilder.newJob(CounselJob.class)
                    .withIdentity(counseling.getUser().getNickName(), "group1")
                    .setJobData(jobDataMap)
                    .build();
            Integer month=counseling.getMonth();
            if(month==1) month=12;
            else month-=1;
            @SuppressWarnings("deprecation")
            SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                    .withIdentity("simple_trigger", "simple_trigger_group")
                    //실제 배포
                    .startAt(new Date(2022 - 1900, month, counseling.getDay(), counseling.getHours(), 0)) // 2022 : 2022 - 1900, month = 7 -> 8월
                    //테스트용
                    //.startAt(new Date(2022 - 1900, month, counseling.getDay(), counseling.getHours(), 12)) // 2022 : 2022 - 1900, month = 7 -> 8월
                    .withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(1, 10)) // 10초마다 반복하며, 최대 1회 실행
                    .forJob(jobDetail)
                    .build();
            Set<SimpleTrigger> triggerSet = new HashSet<SimpleTrigger>();
            triggerSet.add(simpleTrigger);
            scheduler.scheduleJob(jobDetail, triggerSet, false);
            scheduler.start();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
