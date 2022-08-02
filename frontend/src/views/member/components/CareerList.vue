<template>
    <div>
      <career-list-item
        v-for="career in $store.state.careers"
        :key="career.date"
        :career="career"
      >
      </career-list-item>
    </div>
</template>
<script>
import CareerListItem from '@/components/CareerListItem'
export default {
    name: 'CareerList',
    components: {
        CareerListItem,
    },
    computed: {
        careers: function () {
            return this.$store.state.careers
        }
    }
}
</script>
<style>
    
</style>