<template>
  <div class="container" id="text-diary-create-form">
    <form @submit.prevent="onSubmit()" class="textDiary-form">
      <p>일기 제목을 입력해주세요. (50자 이내)</p>
            <input v-model="data.title" type="text" placeholder="제목을 입력하시오" maxlength="50" id="text-title">
          <p class="mt-5">일기 내용을 입력해주세요.</p>
            <p>(후에 추가 수정은 불가합니다.)</p>
              <textarea v-model="data.contents" placeholder="일기 내용을 입력하시오" id="text-contents"></textarea> <br>
      <button type="submit" class="btn" id="textDiary-form-submit-button">저장</button>
    </form>
  </div>
      
</template>
<script>
import { mapActions } from 'vuex'
export default {
  name : 'contentComp',
  components: {},
  data() {
    return {
      data: {
        contents: '',
        title: '',
        
      }
    }
  },
  methods: {
    ...mapActions(['createTextDiary']),
    onSubmit() {
      const subData = {
        title: this.data.title,
        contents: this.data.contents,
      }
      console.log(subData)
      console.log('2')
      this.createTextDiary(subData)
    }
  },
}
</script>

<style>
#text-diary-create-form{
  justify-content: center;
  text-align:center;
}

#text-title{
  width:80%;
}
#text-contents {
  width:80%;
  height:300px;
}
</style>