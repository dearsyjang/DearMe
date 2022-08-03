<template>
    <div>
      <span>{{ career.title }}</span>
      <button @click="deleteCareer">삭제</button>
    </div>
</template>
<script>
export default {
    name: 'CareerListItem',
    props: {
        career: {
            type: Object,
        }
    },
    methods: {
        deleteCareer: function () {
            this.$store.dispatch('deleteCareer', this.career)
        },
    }
}
</script>
<style>
    
</style>