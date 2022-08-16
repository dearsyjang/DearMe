<template>
<div id="home">
    <div id="carouselExampleSlidesOnly" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="../assets/images/main.png" id="main" class="d-block w-100" alt="main">
    </div>
    <div class="carousel-item">
      <img src="../assets/images/main2.png" id="main2" class="d-block w-100" alt="main2">
    </div>
    <div class="carousel-item">
      <img src="../assets/images/main3.png" id="main3" class="d-block w-100" alt="main3">
    </div>
  </div>
</div>
    <router-link :to="{ name:'login' }"><button id="login-button" class="btn">로그인</button></router-link>
    <router-link :to="{ name:'signupuser' }"><button id="signup2-button" class="btn">일반 회원가입</button></router-link>
    <router-link :to="{ name:'signupcounselor' }"><button id="signup2-button" class="btn">상담사 회원가입</button></router-link>
</div>

</template>

<script>

export default {
}
</script>

<style scoped>
#home{
  width: 100%;
  height: 100%;
  background-color: #F9F7F7;
}
#signup-button {
  background-color: #A7BBC7;
  width: 100%;
  height: auto;
  color: white;
  border-width: 0px;
  border-radius: 5px;
  margin-bottom: 20px;
}

#signup2-button {
  background-color: #91C483;
  width: 100%;
  height: auto;
  color: white;
  border-width: 0px;
  border-radius: 5px;
  margin-bottom: 20px;
}

/* #login-button {
  background-color: #FF6464;
  width: 100%;
  height: auto;
  color: white;
  border-width: 0px;
  border-radius: 5px;
  margin-bottom: 20px;
} */

#login-button {
  background: #b621fe;
  border: none;
  z-index: 1;
}
#login-button:after {
  position: absolute;
  content: "";
  width: 0;
  height: 100%;
  top: 0;
  right: 0;
  z-index: -1;
  background-color: #663dff;
  border-radius: 5px;
   box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
   7px 7px 20px 0px rgba(0,0,0,.1),
   4px 4px 5px 0px rgba(0,0,0,.1);
  transition: all 0.3s ease;
}
#login-button:hover {
  color: #ffff;
}
#login-button:hover:after {
  left: 0;
  width: 100%;
}
#login-button:active {
  top: 2px;
}

.carousel-inner{
  width:auto;
  height:auto;
}

/* .carousel-item{
  width: auto;
  height:auto%;
} */
</style>
