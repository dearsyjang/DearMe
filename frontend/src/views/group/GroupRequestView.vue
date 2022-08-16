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
          <div class="d-flex justify-content-end">
            <label for="toggle" class="toggleSwitch mx-2">
              <span @click="clickToggle()" class="toggleButton"></span>
            </label>
            <p>감정달력 {{ openMent }}</p>
          </div>
        </div>
        <textarea class="form-control" v-model="contents" rows="13" placeholder="상담 내용을 입력하시오."></textarea>
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
      isOpen: false,
      contents: "",
      openMent: '비공개'
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
      console.log(data)
      this.groupRequest(data)
    },
    // switchOpen() {
    //   this.isOpen = !this.isOpen
    // },
    clickToggle() {
    const toggle = document.querySelector(".toggleSwitch");
    toggle.classList.toggle('active');
    this.isOpen = !this.isOpen
    if ( this.isOpen === true ) {
      this.openMent = '공개'
    }else{
      this.openMent = '비공개'
    }

    }
  },
  computed: {
    ...mapGetters(['currentUser', 'group'])
  }
};
</script>
<style>
.toggleSwitch {
  width: 40px;
  height: 20px;
  display: block;
  position: relative;
  border-radius: 2rem;
  background-color: #fff;
  box-shadow: 0 0 1rem 3px rgba(0, 0, 0, 0.043);
  cursor: pointer;
}

.toggleSwitch .toggleButton {
  width: 1rem;
  height: 1rem;
  position: absolute;
  top: 50%;
  left: .2rem;
  transform: translateY(-50%);
  border-radius: 50%;
  background: #F6CF72;
}

/* 체크박스가 체크되면 변경 이벤트 */
.toggleSwitch.active {
  background: #F6CF72;
}

.toggleSwitch.active .toggleButton {
  left: calc(100% - 1.3rem);
  background: #fff;
}

.toggleSwitch, .toggleButton {
  transition: all 0.2s ease-in;
}
</style>
