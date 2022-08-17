<template>
  <div class="container">
    <form @submit.prevent="updateUserProfile">
    <div class="unchangable-info">
      <br>
      아이디 : {{currentUser.data.id}}
      <hr>
      이메일 : {{currentUser.data.email}}
      <hr>
      성별 : {{currentUser.data.gender}}
      <hr>
      닉네임 : {{currentUser.data.nickname}}
      <hr>
    </div> 
      <div class="form-group">
        <label class="form-label mt-2" for="nickname">새 닉네임</label>
        <div class="row">
          <input type="text" class="form-control col-sm-6 mx-3" placeholder="닉네임" id="inputId" v-model="update.credentials.nickName">
          <button @click="nicknameCheck()" class="btn btn-primary col-sm-3" id="nncheck">중복검사</button>
        </div>
      </div>
      <hr>
      <div class="change-pw">      
        <p>비밀번호 변경</p>
      <div class="form-group has-success">
        <label class="form-label mt-2" for="password1">새 비밀번호</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호" v-model="update.credentials.pw">
      </div>
      <div class="form-group has-danger">
        <label class="form-label mt-2" for="password2">새 비밀번호 확인</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호 확인" v-model="update.credentials.pw2">
        <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
      </div>
      </div>

    
      
      <hr>
      사진 : {{currentUser.pictureUrl}}
      <div class="itemFileBox" ref="itemFileBox">
        <input type="file" 
                class="item-file-image" 
                id="uploadItemFile" 
                ref="uploadItemFile"
                @change="onFileSelected"
                accept="image/*"
        />
        <label for="uploadItemFile">
          <div class="wrapper-image" >
              <img id = "profile" ref="uploadItemImage">
          </div>      
        </label>
        </div>  
     
    <br><br>
    <button class="btn btn-dark col-sm-3" type="submit" id="profile-btn">수정하기</button>
    </form>
  
    <button class="btn btn-warning col-sm-3"  @click="deleteUser" id="tal">탈퇴하기</button>
      <br><br><br><br>
      <br><br><br><br>
  </div>
</template>

<script>

import {  mapActions, mapGetters} from 'vuex'
import axios from 'axios'
import drf from '@/api/drf'

  export default {
    data() {
      return {
        update: {
        counselorProfile: {
          introduce: '하잉',
          price: 1234

        },
        credentials: {
          nickName:'',
          pw: '',
          pw2: '',

        }
        }

      }
    },
    name: 'ProfileUserView',


    computed : {
    ...mapGetters(['currentUser' ]),

    },
    methods: {
    ...mapActions(['fetchCurrentUser', 'updateProfile', 'deleteUser' ]),
    onFileSelected(event){
      let image = event.target;
      if(image.files[0]){
                
        let itemImage = this.$refs.uploadItemImage; //img dom 접근
        
        itemImage.src = window.URL.createObjectURL(image.files[0]);//img src에 blob주소 변환
        
        
        itemImage.width ='100'; // 이미지 넓이
        
     
      }
    },
    nicknameCheck(){
      axios({
        url: drf.member.nickNameCheck(this.update.credentials.nickName),
        method: 'get'
      })
      .then(res => {
        alert(`${this.update.credentials.nickName}는 사용가능한 닉네임 입니다.`)
        console.log(res.data)
        console.log(res.data.data)
      })
      .catch(err => {
        alert(err.response.data.message)
        // console.error(err.response.data.message)
      })
    },
    getImage () {
      const img = document.getElementById('profile');
      img.src = this.currentUser.data.pictureUrl
        
    },
    updateUserProfile () {
      // console.log(this.currentUser.data.type)
      // console.log(this.currentUser.data.counselorProfileInfoDto.introduce)
      if (this.currentUser.data.type === 'USER') {
        this.update.counselorProfile = null  
      } else {
        this.update.counselorProfile.price = this.currentUser.data.counselorProfileInfoDto.price
        this.update.counselorProfile.introduce = this.currentUser.data.counselorProfileInfoDto.introduce
      } 

      this.updateProfile(this.update)
    },
    updateImage () {
      const authHeader = this.authHeader2
        axios({
            method:'put', 
            url: "https://i7d206.p.ssafy.io/users/image",
            headers: {
              'Content-Type': 'multipart/form-data',
              Authorization : authHeader,
            },
            data: ({
              picture: document.getElementById('formElem')[0].files[0],
              }),
            })
        .then(response => {
            console.log(response);
        })
        .catch(error => {
            console.error(error)
        });
    }
    },
    
  created() {
    this.fetchCurrentUser()
    
  },
  mounted(){
    this.getImage();
  },
}
</script>



<style>

#profile-btn{
  float:left;
  color: black;
  background-color:white
}

#nncheck{
  width:30%;
  color: black;
  background-color:white

}

#inputId{
  width: 50%;
 
}

#tal{
  float:right;
  color: black;
  background-color:white
}

.unchangable-info{
   font-weight : bold
}
</style>