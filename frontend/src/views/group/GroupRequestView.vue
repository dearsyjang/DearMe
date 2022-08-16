<template>
  <div class="page-content-wrapper py-3 group-bg">
    <div class="container">
      <div class="card my-2">
        <div class="card-body p-2">
          <div class="justify-content-between">
            <small class="ms-1 board-text-index">그룹 참가 신청</small>
            <!-- <div>
              <router-link to="/board"><button class="board-btn-index btn-sm mx-2">목록</button></router-link>
            </div> -->
          </div>
        </div>
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h1>{{ group.title }}</h1>
          <h5>{{ group.counselor}} 상담사</h5>
        </div>
      </div>
      <div class="card product-details-card mb-3 direction-rtl">
        <div class="card-body">
          <h5>그룹 상담 신청 내용</h5>
        </div>
        <textarea class="form-control" cols="3" rows="15" placeholder="상담 내용을 입력하시오."></textarea>
    </div>
    <form action="#" class="text-center ">
      <router-link :to="{name: 'groupRequest', params: {groupId: this.group.id}}">
        <button @click="onSubmit()" class="w-btn-neon2 " type="button">그룹 참가신청</button>
      </router-link>
    </form>
  </div>
</div>
</template>
<script>
import { mapActions, mapGetters } from "vuex";
export default {
  components: {},
  data() {
    return {
      groupId: this.$route.params.groupId,
      isOpen: true,
      contents: "",
    };
  },
  created() {
    this.fetchGroup(this.groupId);
  },
  methods: {
    ...mapActions(["groupRequest", 'fetchGroup']),
    onSubmit() {
      const data = {
        id: this.groupId,
        isOpen: this.isOpen,
        contents: this.contents
      }
      this.groupRequest(data)
    },
    switchOpen() {
      this.isOpen = !this.isOpen
    }
  },
  computed: {
    ...mapGetters(['currentUser', 'group'])
  }
};
</script>
<style>

</style>
