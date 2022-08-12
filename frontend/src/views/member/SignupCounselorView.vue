<template>
<div>
  <div class="popup popup-signup">
        <div class="content-block">
            <h4>REGISTER</h4>
            <div class="loginform">
                <form id="RegisterForm" method="post">
                    <input type="text" name="Username" value="" class="form_input required" placeholder="Username" />
                    <input type="text" name="Email" value="" class="form_input required" placeholder="Email" />
                    <input type="password" name="Password" value="" class="form_input required" placeholder="Password" />
                    <input type="submit" name="submit" class="form_submit" id="submitregister" value="SIGN UP" />
                </form>
            </div>
            <div class="close_popup_button">
                <a href="#" class="close-popup"><img src="images/icons/black/menu_close.png" alt="" title="" /></a>
            </div>
        </div>
    </div>
</div>
  <!-- <div>
    <div class="login">
    <div class="login__content">
      <div class="login__forms">
        <form class="login__register" id="login-in">
          <h1 class="login__title">USER</h1>
          <div class="login__box">
            <i class='bx bx-user login__icon'></i>
            <input type="text" placeholder="id" class="login__input" v-model="credentials.id">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="password" placeholder="Password" class="login__input" v-model="credentials.pw">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="email" placeholder="email" class="login__input" v-model="credentials.email">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="nickName" class="login__input" v-model="credentials.nickName">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="생년월일8자리" class="login__input" v-model="credentials.birth">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <select class="form-select login__input" v-model="credentials.gender" id="gender" aria-label="Default select example">
              <option selected>성별</option>
              <option value="MALE">남자</option>
              <option value="FEMALE">여자</option>
            </select>
          </div>

          <a href="#" class="login__forgot">Forgot Password? </a>
          <a @click="signUp()" class="login__button">SIGNUP</a>
          <div>
            <span class="login__account login__account--account">사용자 유형 변경 >> </span>
            <span @click="test()" class="login__signin login__signin--signup" id="sign-up">상담사</span>
          </div>
        </form>

        <form class="login__create none" id="login-up">
          <h1 class="login__title">COUNSELOR</h1>
          <div class="login__box">
            <i class='bx bx-user login__icon'></i>
            <input type="text" placeholder="id" class="login__input" v-model="credentials.id">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="password" placeholder="Password" class="login__input" v-model="credentials.pw">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="email" placeholder="email" class="login__input" v-model="credentials.email">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="nickName" class="login__input" v-model="credentials.nickName">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <input type="text" placeholder="생년월일8자리" class="login__input" v-model="credentials.birth">
          </div>
          <div class="login__box">
            <i class='bx bx-lock login__icon'></i>
            <select class="form-select login__input" v-model="credentials.gender" id="gender" aria-label="Default select example">
              <option selected>성별</option>
              <option value="MALE">남자</option>
              <option value="FEMALE">여자</option>
            </select>
          </div>

          <a @click="signUp()" href="#" class="login__button">SIGNUP</a>

          <div>
            <span class="login__account login__account--account">사용자 유형 변경 >> </span>
            <span class="login__signup login__signup--signup" id="sign-in">취업준비생</span>
          </div>
        </form>
      </div>
    </div>
   </div>
  </div> -->
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
import axios from 'axios'
import drf from '@/api/drf'
export default {
  components: {},
  data() {
    return {
      isCounselor: false,
      credentials: {
        id: '',
        pw: '',
        type: '',
        nickName: '',
        birth: '2022/02/02',
        gender: '',
        email: '',
        picture: '',
      },
      months: [
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12
      ],
      days: [
        1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31
      ],
      category: [

      ]
    }
  },
  computed: {
    ...mapGetters(['authError'])
  },
  methods: {
    ...mapActions([ 'signup' ]),
    signUp() {
      let formData = new FormData()
      formData.append('id', this.credentials.id)
      formData.append('pw', this.credentials.pw)
      formData.append('type', this.credentials.type)
      formData.append('nickName', this.credentials.nickName)
      formData.append('birth', this.credentials.birth)
      formData.append('gender', this.credentials.gender)
      formData.append('email', this.credentials.email)
      this.signup(formData)
      // console.log(formData.getAll('id'))
    },
    // 아이디 중복 확인 (response 수정해야함)
    idCheck(){
      axios({
        url: drf.member.idCheck()+`/${this.credentials.id}`,
        method: 'get'
      })
      .then(res => {
        if (res.status === 'success'){
          alert('사용 가능한 아이디 입니다.')
        }
        else{
          alert('중복된 아이디가 존재합니다.')
        }
      })
    },
    imCounselor() {
      this.isCounselor = true
      this.credentials.type = 'COUNSELOR'
      // console.log(this.isCounselor)
      // console.log(this.credentials.type)
    },
    imUser() {
      this.isCounselor = false
      this.credentials.type = 'USER'
    },

    test() {
      const signup = document.getElementById("sign-up");
      const signin = document.getElementById("sign-in");
      const loginin = document.getElementById("login-in");
      const loginup = document.getElementById("login-up");

      signup.addEventListener("click", () => {
          loginin.classList.remove("block");
          loginup.classList.remove("none");

          loginin.classList.add("none");
          loginup.classList.add("block");

          this.credentials.type = 'COUNSELOR'
      })

      signin.addEventListener("click", () => {
          loginin.classList.remove("none");
          loginup.classList.remove("block");

          loginin.classList.add("block");
          loginup.classList.add("none");
          this.credentials.type = 'USER'
      })
    }
  },
  created() {},
  mounted() {},
  unmounted() {},
}
</script>
<style scoped lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600;700&display=swap');

$color:#8CB2B6;
$color-dark:#23004d;
$color-light:#a49eac;
$color-lighten:#f2f2f2;
$color-hover:#8CB2B6;
$font:"Open Sans", sans-serif;
$big-font-size:1.5rem;
$normal-font-size:0.938rem;
$small-font-size:0.813rem;

@media screen and (min-width:768px){
  $normal-font-size:1rem;
$small-font-size:0.875rem;
}
*,::before,::after{
  box-sizing:border-box;
}
body{
  margin:0;
  padding:0;
  font-family:$font;
  font-size:$normal-font-size;
  color:$color-dark;
}
h1{
  margin:0;
}
a{
  text-decoration:none;
}
img{
  max-width:100%;
    height:auto;
  display:block;
}

.login{
  display:grid;
  grid-template-columns:100%;
  height:100vh;
  margin-left:1.5rem;
  margin-right:1.5rem;

  &__content{
    display:grid;
  }
  &__img{
    justify-self:center;

    img{
      width:310px;
      margin-top:1.5rem;
    }
  }
  &__forms{
    position:relative;
    height:368px;
  }
  &__register,&__create{
    position:absolute;
    bottom:1rem;
    width:100%;
    background-color:$color-lighten;
    padding:2rem 1rem;
    border-radius:1rem;
    text-align:center;
    box-shadow:0 8px 20px rgba(35,0,77,.2);
    animation-duration:.4s;
    animation-name:animateLogin;
  }
  &__title{
    font-size:$big-font-size;
    margin-bottom:2rem;
  }
  &__box{
    display:grid;
    grid-template-columns:max-content 1fr;
    column-gap:.5rem;
    padding:1.125rem 1rem;
    background-color:#fff;
    margin-top:1rem;
    border-radius:.5rem;
  }
  &__icon{
    font-size:1.5rem;
    color:$color;
  }
  &__input{
    border:none;
    outline:none;
    font-size:$normal-font-size;
    font-weight:700;
    color:$color-dark;
    width:100%;

    &::placeholder{
      font-size:$normal-font-size;
      font-family:$font;
      color:$color-light;
    }
  }
  &__forgot{
    display:block;
    width:max-content;
    margin-left:auto;
    margin-top:.5rem;
    font-size:$small-font-size;
    font-weight:600;
    color:$color-light;
  }
  &__button{
    display:block;
   padding:1rem;
    margin:2rem 0;
    background-color:$color;
    color:#fff;
    font-weight:600;
    text-align:center;
    border-radius:.5rem;
    transition:.3s;

      &:hover{
        background-color:$color-hover;
        }
  }
  &__account,&__signin,&__signup{
    font-weight:600;
    font-size:$small-font-size;

    &--account{
      color:$color-dark;
    }
    &--signin,&--signup{
      color:$color;
      cursor:pointer;
    }
  }
  &__social{
    margin-top:2rem;

    &--icon{
      font-size:1.5rem;
      color:$color-dark;
      margin:0 1rem;
    }
  }
}
.block{
  display:block;
}
.none{
  display:none;
}
@keyframes animateLogin{
  0%{
    transform:scale(1,1);
  }
  50%{
    transform:scale(1.1,1.1);
  }
  100%{
    transform:scale(1,1);
  }
}

@media screen and (min-width:576px){
  .login{
    &__forms{
      width: 348px;
      justify-self:center;
    }
  }
}
@media screen and (min-width:1024px){
  .login{
    height:100vh;
    overflow:hidden;
    &__content{
      grid-template-columns:repeat(2,max-content);
      justify-content:center;
      align-items:center;
      margin-left:10rem;
    }
    &__img{
      display:flex;
      width:600px;
      height:588px;
      background-color:#fff;
      border-radius:1rem;
      padding-left:1rem;

      img{
        width:80%;
        margin-top:0;
      }
    }
    &__register,&__create{
      left:-11rem;
    }
    &__register{
      bottom:-2rem;
    }
    &__create{
      bottom:-5.5rem;
    }
  }
}

.signup_bottom{
width:100%;
text-align:center;
padding:30px 0 0 0;
}
.signup_bottom p{
opacity: 1;
padding:0px 0 10px 0;
font-size:16px;
}
.signup_bottom a{
background-color:#7cbe55;
color:#fff;
font-weight:300;
font-size:16px;
padding:5px 10px;
border-radius:15px;
}
.signup_social{
width:100%;
text-align:center;
padding:20px 0 0 0;
}
a.signup_facebook{
background-color:#38579a;
width:47%;
display:inline-block;
padding:12px 0;
margin:0 4% 0 0;
color:#FFFFFF;
font-size:12px;
font-weight:700;
}
a.signup_twitter{
background-color:#0cacea;
width:47%;
padding:12px 0;
display:inline-block;
color:#FFFFFF;
font-size:12px;
font-weight:700;
}
.popup{
background-color:#FFFFFF;
}
.popup h4{
color:#222222;
font-size:22px;
font-weight:700;
text-align:center;
padding:0 0 20px 0;
margin:0px;
}
.popup h5{
color:#222222;
font-size:14px;
font-weight:300;
text-align:center;
padding:20px 0 10px 0;
margin:0px;
}
.popup p{
text-align:center;
padding:0px 0 20px 0;
margin:0px;
font-size:14px;
}
.content-block {
padding:75px 10% 0 10%;
}
.loginform{
width:90%;
padding:0 0 15px 5%;
}
.loginform label.error{
padding:0 0 20px 0;
margin:0px;
line-height:10px;
width:100%;
text-align:left;
font-size:14px;
color:#f65821;
font-weight:400;
clear:both;
float:left;
}
.loginform input.form_input{
padding:10px 3%;
width:93%;
margin:0 0 15px 0;
border-bottom:1px solid #d5d5d5;
border-left:none;
border-right:none;
border-top:none;
background-color:#ffffff;
color:#000000;
-webkit-appearance: none;
}
.loginform input.form_input:focus{
 background-color:#f5f5f5;
}
.loginform .form_select{
padding:2% 3%;
width:100%;
margin:20px 0 10px 0;
border-bottom:1px solid #d5d5d5;
border-left:none;
border-right:none;
border-top:none;
-webkit-appearance: none;
color:#000000;

}
.loginform .form_select option{
padding:3px;
}
.loginform input.form_submit{
width:100%;
padding:12px 0;
margin:10px 0 0 0;
text-align:center;
cursor:pointer;
font-size:18px;
font-weight:300;
color:#222222;
border: none;
cursor:pointer;
-webkit-appearance: none;
 background-color:#0be0af;
}
</style>