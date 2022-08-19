<template>
    <div>
      {{ career.title }}
    </div>
</template>
<script>
export default {
    name: 'CareerListItem',
    props: {
        career: {
            type: Object,
        }
    }
}
</script>
<style>
    
</style>