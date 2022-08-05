<template>
<div>
    <article-form></article-form>
</div>
</template>
<script>
import ArticleForm from './components/ArticleForm.vue'

export default {
  components: { ArticleForm  },
  data(){
    return {
        article: {
            title: '',
            content: '',
        }
    }
  }

}
</script>

<style>

</style>