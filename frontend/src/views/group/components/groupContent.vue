<template>
  <div>
    <div>
      <p id="detailTitle">[{{group.title}} 공지사항]</p>
    </div>
    <div id="groupContent">
      <!-- .를 기준으로 줄을 나눠야할지 고민 -->
      <div>
        <p>상담방 공지사항</p>
        <p>{{ group.contents }}</p>
        <p>상담방 가격</p>
        <p>{{ group.price }}</p>

      </div>
    </div>
    <!-- isCounselor 여부로 신청버튼 유무 결정 -->
    <router-link :to="{name : 'groupRequest', params: {title:group.title}}"><button>신청</button></router-link>
  </div>
</template>
<script>
export default {
  components: {},
  props: {
    group: Object
  },
  data() {
    return {};
  },
  setup() {},
  created() {
  },
  mounted() {},
  unmounted() {},
  methods: {

  },
  computed: {

  }
};
</script>
<style scoped>
p {
  text-align: left;
}
#groupContent {
  background-color: #f0f5f9;
}
#detailTitle {
  font-weight: bold;
}
</style>
