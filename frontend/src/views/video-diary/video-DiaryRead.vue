<template>
    <div>
        <h1>영상 다시보기</h1>
        <div>
            <video controls width="250" class="video_diary">
            <source :src="video" type="video/mp4">
        </video>
        </div>
    </div>        
</template>

<script>
export default {
    data() {
        return {
            sessionId: '',
            video: '',
            recordingId: '',
        }
    },
    methods: {
        created() {
            
        }
    }
}

</script>

<style>

</style>