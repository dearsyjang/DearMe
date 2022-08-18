<template>
<div id="home">
<div class="page-content-wrapper py-3 board-bg">
  <div class="shop-pagination pb-3 my-3">
    <div class="container">
      <div id="carouselExampleSlidesOnly" class="carousel slide img-container" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="@/assets/images/main.png" id="main" class="d-block W-100" alt="main">
          </div>
          <div class="carousel-item">
            <img src="@/assets/images/main2.png" id="main2" class="d-block W-100" alt="main2">
          </div>
          <div class="carousel-item">
            <img src="@/assets/images/main3.png" id="main3" class="d-block W-100" alt="main3">
          </div>
        </div>
      </div>
    </div>
    <div class="container my-5">
      <p class="home-font">오늘도 수고했어요</p>
      <p >오늘 당신의 하루를 들려주세요 😊</p>
    </div>
    <div class="container">
    <div>
      <router-link :to="{ name:'login' }"><button id="login-button" class="w-btn-login btn-font">LOGIN</button></router-link>
    </div>
    <div>
      <router-link :to="{ name:'signuptype' }"><button id="signup2-button" class="w-btn-signup btn-font">SIGN UP</button></router-link>
    </div>



    </div>
    </div>
</div>
</div>
</template>

<script>

export default {
}
</script>

<style scoped>
p {
  font-size:  3.0vh;
}
.btn-font {
  font-size: 2.0vh;
}
.img-container {
  width: 80%;
}
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
    width: 60%;
    /* min-width: 170px; */
    /* min-height: 50px; */
    height: 6.0vh;
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
.w-btn-signup {
    /* position: relative; */
    border: none;
    width: 60%;
    /* min-width: 170px; */
    /* min-height: 50px; */
    height: 6.0vh;
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
  justify-content: center;
  margin:auto;
  width: 70%;
  height: 30%;
}
/* .carousel-item{
  width: auto;
  height:auto%;
} */
</style>