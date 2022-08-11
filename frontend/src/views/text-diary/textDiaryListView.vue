<template>
  <div>
    <div class="card-body">
        {{ textDiaries }}asdf
    </div>
    
  </div>
</template>
<script>
import { mapActions, mapGetters } from 'vuex'
export default {
  name : 'textDiaryList',
  components: {},
  data() {
    return {
      sampleData: ''
    }
  },
  computed: {
    ...mapGetters(['textDiaries'])
  },
  setup() {},
  created() {
    this.fetchTextDiaries(this.textDiaries)
  },
  mounted() {},
  unmounted() {},
  methods: {
    ...mapActions(['fetchTextDiaries'])
  }
}
</script>
