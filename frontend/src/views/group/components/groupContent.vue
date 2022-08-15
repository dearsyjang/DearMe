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
        <p>{{group.id}}</p>

      </div>
    </div>
    <!-- isCounselor 여부로 신청버튼 유무 결정 
    v-if 상담사는 상담방 개설, user는 신청하기 버튼-->
    <div v-if="currentUser.data.type==`USER`">
    <router-link :to="{name : 'groupRequest', params: {title:group.title}}"><button>신청</button></router-link>
    </div>
    <div v-if="currentUser.data.type==`COUNSELOR`">
    <router-link :to="{name : 'counselinggroup', params: {groupId: group.id}}"><button>그룹 상담방 개설</button></router-link>
    </div>
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'


export default {
  components: {},
  props: {
    group: Object
  },
  data() {
    return {
      groupId: this.$route.params.groupId
    };
  },
    computed: {
    ...mapGetters(['currentUser'])
  },
  methods: {
    ...mapActions(['fetchCurrentUser'])
  },
  created() {
    this.fetchCurrentUser()
  }
}

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
