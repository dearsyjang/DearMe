<template>
  <div class="container">
    <form @submit.prevent="updateUserProfile">
      아이디 : {{currentUser.data.id}}
      <hr>
      <p>현재 비밀번호</p>
        <input type="text">
      <div class="form-group has-success">
        <label class="form-label mt-2" for="password1">새 비밀번호</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호" v-model="update.credentials.pw">
      </div>
      <div class="form-group has-danger">
        <label class="form-label mt-2" for="password2">새 비밀번호 확인</label>
        <input type="password" class="form-control is-valid" placeholder="비밀번호 확인" v-model="update.credentials.pw2">
        <div class="invalid-feedback">비밀번호가 일치하지 않습니다.</div>
      </div>
      <hr>
      닉네임 : {{currentUser.data.nickname}}
      <hr>
      <div class="form-group">
        <label class="form-label mt-2" for="nickname">닉네임</label>
        <div class="row">
          <input type="text" class="form-control col-sm-6 mx-3" placeholder="닉네임" id="inputId" v-model="update.credentials.nickName">
          <button @click="idCheck()" class="btn btn-primary col-sm-3" id="sameId">중복검사</button>
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
      <hr>
      이메일 : {{currentUser.data.email}}
      <hr>
      성별 : {{currentUser.data.gender}}
    
      <button type="submit">수정하기</button>
    </form>

    <button @click="deleteUser">탈퇴하기</button>

  </div>
</template>

<script>

  import {  mapActions, mapGetters} from 'vuex'
import axios from 'axios'
  export default {
    data() {
      return {
        update: {
        counselorProfile: {
          introduce: '',
          price: ''

        },
        credentials: {
          pw: '',
          nickName: '',

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



</style>