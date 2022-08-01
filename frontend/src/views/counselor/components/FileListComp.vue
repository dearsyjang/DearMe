<template>
  
  <div class="file-list">
    <file-list-item-comp
    >
    </file-list-item-comp>
  </div>
</template>

<script>
import FileListItemComp from '@/views/counselor/components/FileListItemComp.vue'
  export default {
    name : 'FileListComp',
    components:{FileListItemComp},
    props:{files:Array}
    
  }

</script>

<style>
.file-list {
  
  margin: auto;
  width: 300px;
  background-color: #F0F5F9;

}
</style>