<template>
    <div>
        <input type="text"
          v-model.trim="careerTitle"
          @keyup.enter="createCareer"
        />
        <button @click="createCareer">추가</button>
    </div>
</template>
<script>
export default {
    name: 'CareerForm',
    data: function () {
      return {
        careerTitle: '',
      }
    },
    methods: {
        createCareer: function () {
            const careerItem = {
                title: this.careerTitle,
                isCompleted: false,
                date: new Date().getTime(),
            }
            if (careerItem.title) {
                this.$store.dispatch('createCareer', careerItem)
            }
            this.careerTitle = ''
        },
    },
    
}
</script>
<style>
    
</style>