<template>
  <div>
    {{info.Content}}
    <button @click="deleteInfo">[x]</button>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
export default {
  name: 'InfoItemComp',
  props: {
    info:Object
  },

  methods: {
    // deleteInfo() {
    //   this.$store.dispatch('deleteInfo', this.info)
    // }
    ...mapActions(['deleteInfo'])
  }
}
</script>
<style></style>