<template>
<div id="home">
  <!-- Hero Block Wrapper -->
  <div>
    <div class="custom-container">
      <!-- Hero Block Content -->
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
        <br>
        <br>
          <h3 id="text">수고했어요, 오늘도!</h3>
          <h3 id="text">오늘 당신의 하루는 어땠나요?</h3>
          <h3 id="text">우리 같이 이야기해볼까요?</h3>
      <div class="m-5">
        <a class="btn btn-warning btn-lg w-100 mb-3" href="/member/login">LOGIN</a>
        <a class="btn btn-warning btn-lg w-100" href="/member/signuptype">SIGN UP</a>
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
@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&display=swap');
* {
  font-family: 'Gowun Dodum', sans-serif;
}

#home{
  display: flex;
  height: 720px;
  margin: 0 auto;
  background-color: #F9F7F7;
  align-items: center;
}

.text {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    font-size: 20px;
    font-weight: 700;
    line-height: 1.2;
    letter-spacing: 0.05em;
    white-space: nowrap;
    text-transform: uppercase;
    color: #112D4E;
    mix-blend-mode: multiply;
    opacity: 0;
    animation: fadeInText 3s 2s ease-out forwards;
    margin: 5;
}

@keyframes scaleImage {
    100% {
        transform: scale(1);
    }
}

@keyframes fadeInText {
    100% {
        opacity: 1;
    }
}

/* .carousel-item{
  width: auto;
  height:auto%;
} */
</style>
