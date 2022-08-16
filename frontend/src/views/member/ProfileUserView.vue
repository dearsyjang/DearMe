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
              <img ref="uploadItemImage">
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
    ...mapGetters(['currentUser',  ]),

    },
    methods: {
    ...mapActions(['fetchCurrentUser', 'updateProfile', 'deleteUser' ]),
    onFileSelected(event){
      let image = event.target;
      if(image.files[0]){
                
        let itemImage = this.$refs.uploadItemImage; //img dom 접근
        
        itemImage.src = window.URL.createObjectURL(image.files[0]);//img src에 blob주소 변환
        
        this.itemImageInfo.uploadImages = itemImage.src; //이미지 주소 data 변수에 바인딩해서 나타내게 처리
        
        itemImage.width ='200'; // 이미지 넓이
        
        itemImage.onload = () => {
          window.URL.revokeObjectURL(this.src)  //나중에 반드시 해제해주어야 메모리 누수가 안생김.
        }
     
      }
    },

    getImage () {
      const authHeader = this.authHeader2
        axios({
            method:'get', 
            url: "https://i7d206.p.ssafy.io/users/image",
            headers: {
              Authorization : authHeader,
            },
            })
        .then(response => {
            console.log(response);
            
          let itemImage = this.$refs.uploadItemImage; //img dom 접근
          itemImage.src = "data:image/png;base64," + btoa(unescape(encodeURIComponent(response.data)))
            document.body.appendChild(itemImage);
        // itemImage.src = window.URL.createObjectURL("https://i7d206.p.ssafy.io//home/ubuntu/docker-volume/image/basic.png");//img src에 blob주소 변환
        
        // this.itemImageInfo.uploadImages = itemImage.src; //이미지 주소 data 변수에 바인딩해서 나타내게 처리
        
        // itemImage.width ='200'; // 이미지 넓이
        
        // itemImage.onload = () => {
        //   window.URL.revokeObjectURL(this.src)  //나중에 반드시 해제해주어야 메모리 누수가 안생김.
        // }
            

            
        })
        .catch(error => {
            console.error(error)
        });
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
    this.getImage();
  },
}
</script>



<style>



</style>