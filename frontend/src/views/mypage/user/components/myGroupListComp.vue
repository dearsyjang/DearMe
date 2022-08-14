<template>
<div class="container direction-rtl">
  <!-- <div class="row " v-for="group in groups" :key="group"></div> -->
    <div class="row ">
      <div class="card">
        <div class="card-body">
          <div class="row"  >
            <p class="col-sm-4">상담방 이름</p>
            <p class="col-sm-4">개설 날짜</p>
            <!-- <p class="col-sm-4">{{ group.title }}</p>
            <p class="col-sm-4">{{ group.date[0] }}.{{ group.date[1] }}.{{ group.date[2] }}</p> -->
            <button class="col-sm-4 btn btn-primary">상담방 입장</button>
            <!-- ()안에 groupid 받아와서 입력 -->
            <button @click="groupCancel()">그룹 탈퇴</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { mapActions} from 'vuex'
export default {
  props: {
    groups: Object
  },
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  setup() {},
  created() {},
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['groupCancel']),

  }
}
</script>
<style scoped>
  /* .MygroupList {
    background-color: #F0F5F9;
  }
  p, button {
    width: 160px;
    display: table-cell;
  } */
</style>
