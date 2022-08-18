<template>
<div id="home">
    <br>
    <br>
    <br>
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
    <br>
    <br>
    <h5>오늘도 수고했어요</h5>
    <h5>오늘 당신의 하루를 들려주세요 😊</h5>
    <br><br>

    <div class="home-btn">
    <router-link :to="{ name:'login' }"><button id="login-button" class="w-btn-login w-100">LOGIN</button></router-link>
    <router-link :to="{ name:'signuptype' }"><button id="signup2-button" class="w-btn-signup w-100">SIGN IN</button></router-link>
    </div>
    <hr>
    <hr>
    <hr>
    <hr>
    <hr>
    <hr>
</div>

</template>

<script>

export default {
}
</script>

<style scoped>
#home{
  width: auto;
  height: 720px;
  background-color: #F9F7F7;
  justify-content: center;
  align-content: center;
  text-align: center;
}
body {
  background-color: #F9F7F7;
  /* overflow: hidden; */
  height: 100%;
}
.w-btn-login {
    /* position: relative; */
    border: none;
    min-width: 170px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        #AF7AB3 0%,
        #AF7AB3 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #5a554747;
    font-weight: 700;
    transition: 0.3s;
    color: #E9E5DC;
    margin-bottom: 10px;
}
.home-btn{
  width:20%;
  justify-content: center;
  margin : auto;
  margin-bottom:500px;

}
.w-btn-signup {
    /* position: relative; */
    border: none;
    min-width: 170px;
    min-height: 50px;
    background: linear-gradient(
        90deg,
        #AF7AB3 0%,
        #5B5792 100%
    );
    border-radius: 1000px;
    color: darkslategray;
    cursor: pointer;
    box-shadow: 12px 12px 24px #5a554747;
    font-weight: 700;
    transition: 0.3s;
    color: #E9E5DC;
    margin-bottom: 10px;
}
.carousel {
  max-width: 30%;
  justify-content: center;
  margin:auto

}
/* .carousel-item{
  width: auto;
  height:auto%;
} */
</style>