<template>
  <div class = "container">
    <div class = "mb-3">
      <label for="title" class = 'form-label'>제목</label>
      <input type="text" v-model="data.fileBoard.title" name ="title" class ="form-control" id="title">
    </div>
    <div class = "mb-3">
      <label for="uploadFile" class = 'form-label'>파일첨부</label>
      <input name="uploadFile" v-on:change="changeFile"  type="file" class ="form-control" id="file">
    </div>
    <div class="d-grid gap-2 d-md-flex justify-content-md-end">
      <router-link to="/counselors/counselor/:counselorId">
        <!-- <router-link
        :to="{ name: 'counselor', params: {counselorId: temp.id} }"> -->
      <button class = "btn btn-primary me-md-2" type="button">취소</button>
      </router-link>
      <router-link to="/counselors/counselor/:counselorId">
        <!-- <router-link
        :to="{ name: 'counselor', params: {counselorId: temp.id} }"> -->
        <button class = "btn btn-primary" type="button" v-on:click="save">저장</button>
      </router-link>
    </div>
  </div>

</template>

<script>
import { reactive} from 'vue'
export default {
  name : 'FileForm',
  setup() {
    const data = reactive ({
      fileBoard: {
        title: null,
        contents: null,
        uploadFile:null
      }
    })
    const save = () => {
      var formData = new FormData();
      formData.append('boardType', data.fileBoard.boardType)
      if (data.fileBoard.title != null){
        formData.append('title', data.fileBoard.title)
      }
      if (data.fileBoard.uploadFile != null){
        formData.append('uploadFile', data.fileBoard.uploadFile)
      }
      fetch('http://localhost:8080/fileboard',{
        method: 'PUT',
        body : formData
      })
      .then(response => response.json())
      .then(response => {
        data.boardList = response.data;
      })
    }
    const changeFile = (e) => {
      data.fileBoard.uploadFile = e.target.files[0]
      console.log(data.fileBoard.uploadFile)
    }
   
    return {
      data: data,
      changeFile: changeFile,
      save : save,
    }
  }
}
</script>

<style >

</style>
