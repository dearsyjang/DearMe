package com.dearme.demo.domain.counseling.service;

import com.dearme.demo.domain.counseling.dto.*;
import com.dearme.demo.domain.counseling.entity.Counseling;
import com.dearme.demo.domain.counseling.entity.Status;
import com.dearme.demo.domain.counseling.exception.NoExistCounselingException;
import com.dearme.demo.domain.counseling.repository.CounselingRepository;
import com.dearme.demo.domain.counselingdocument.entity.CounselingDocument;
import com.dearme.demo.domain.group.entity.Group;
import com.dearme.demo.domain.user.entity.Type;
import com.dearme.demo.domain.user.entity.User;
import com.dearme.demo.domain.user.exception.NoExistCounselorException;
import com.dearme.demo.domain.user.exception.NoExistUserException;
import com.dearme.demo.domain.user.repository.UserRepository;
import com.dearme.demo.global.scheduler.CounselDayJob;
import com.dearme.demo.global.scheduler.CounselTimeJob;
import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CounselingServiceImpl implements CounselingService{
    private final CounselingRepository counselingRepository;

    private final UserRepository userRepository;

    @Value("${message.access:0}")
    private String ACCESS;

    @Value("${message.secret:0}")
    private String SECRET;

    @Value("${message.url:}")
    private String ID_URL;

    @Override
    public void createCounseling(CounselingDocument counselingDocument) {

        Counseling counseling = counselingDocument.toCounselingEntity();
        counseling.setCounselingDocument(counselingDocument);
        counselingRepository.save(counseling);


    }

    @Override
    public CounselingInfoListResponseDto getCounselings(String id) {
        User user = userRepository.findUserById(id).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        List<Counseling> counselings = null;
        List<CounselingInfoResponseDto> counselingInfoResponseDtos = new ArrayList<>();
        List<CounselorGroupCounselingsResponseDto> counselorGroupCounselingsResponseDtos = new ArrayList<>();
        if(user.getType().equals(Type.USER)) {
            counselings = user.getUserCounselings();
            for(Counseling counseling : counselings){
                counselingInfoResponseDtos.add(CounselingInfoResponseDto.of(counseling));
            }
        }
        else {
            counselings = user.getCounselorCounselings();
            for(Counseling counseling : counselings){
                if(counseling.getGroup() == null)
                    counselingInfoResponseDtos.add(CounselingInfoResponseDto.of(counseling));
            }
            List<Group> groups = user.getGroups();
            for(Group group : groups){
                counselorGroupCounselingsResponseDtos.add(CounselorGroupCounselingsResponseDto.of(group));
            }
        }


        return new CounselingInfoListResponseDto(counselingInfoResponseDtos, counselorGroupCounselingsResponseDtos);
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
        }else if (dto.getStatus().equals(Status.ACCEPTED)){
            //createTimeScheduler(target);
            //createDayScheduler(target);
            target.updateCounseling(dto.getStatus());
            counselingRepository.save(target);
        }else{
            target.updateCounseling(dto.getStatus());
            counselingRepository.save(target);
        }
        return null;
    }

    public void createTimeScheduler(Counseling counseling){
        User user = userRepository.findUserById(counseling.getUser().getId()).orElseThrow(() -> {
            throw new NoExistUserException();
        });

        User counselor = userRepository.findUserById(counseling.getCounselor().getId()).orElseThrow(() -> {
            throw new NoExistCounselorException();
        });

        try {
            // Scheduler 사용을 위한 인스턴스화
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            // JOB Data 객체
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("ACCESS", ACCESS);
            jobDataMap.put("SECRET", SECRET);
            jobDataMap.put("ID_URL", ID_URL);
            jobDataMap.put("phone1", user.getPhone());
            jobDataMap.put("phone2", counselor.getPhone());
            jobDataMap.put("nickName", counseling.getCounselor().getNickName());
            jobDataMap.put("date", counseling.getYear()+"." + counseling.getMonth()+"."+counseling.getDay()+" " + counseling.getHours()+"시");
            JobDetail jobDetail = JobBuilder.newJob(CounselTimeJob.class)
                    .withIdentity(counseling.getId()+"_time_counseling", counseling.getId()+"_time_counseling_group")
                    .setJobData(jobDataMap)
                    .build();
            Integer month=counseling.getMonth();
            if(month==1) month=12;
            else month-=1;
            @SuppressWarnings("deprecation")
            SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                    .withIdentity(counseling.getId()+"_time_counseling_trigger", counseling.getId()+"_time_counseling_trigger_group")
                    //실제 배포
                    .startAt(new Date(counseling.getYear() - 1900, month, counseling.getDay(), counseling.getHours()-1, 0)) // 2022 : 2022 - 1900, month = 7 -> 8월
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
    public void createDayScheduler(Counseling counseling){
        User user = userRepository.findUserById(counseling.getUser().getId()).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        User counselor = userRepository.findUserById(counseling.getCounselor().getId()).orElseThrow(() -> {
            throw new NoExistUserException();
        });
        try {
            // Scheduler 사용을 위한 인스턴스화
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();
            // JOB Data 객체
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("ACCESS", ACCESS);
            jobDataMap.put("SECRET", SECRET);
            jobDataMap.put("ID_URL", ID_URL);
            jobDataMap.put("phone1", user.getPhone());
            jobDataMap.put("phone2", counselor.getPhone());
            jobDataMap.put("nickName", counseling.getCounselor().getNickName());
            jobDataMap.put("date", counseling.getHours()+"시");
            JobDetail jobDetail = JobBuilder.newJob(CounselDayJob.class)
                    .withIdentity(counseling.getId()+"_day_counseling", counseling.getId()+"_day_counseling_group")
                    .setJobData(jobDataMap)
                    .build();
            Integer month=counseling.getMonth();
            if(month==1) month=12;
            else month-=1;
            @SuppressWarnings("deprecation")
            SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                    .withIdentity(counseling.getId()+"_day_counseling_trigger", counseling.getId()+"_day_counseling_trigger_group")
                    //실제 배포
                    .startAt(new Date(counseling.getYear() - 1900, month, counseling.getDay()-3, 8, 30)) // 2022 : 2022 - 1900, month = 7 -> 8월
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
