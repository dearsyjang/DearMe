<template>
<div id="ScheduleCard">
    <!--@click="" => method 연결하기 -->
    <div class="card" style="width: 18rem; height: 8rem;">
        <div class="card-body">
            <h5 class="card-title">상담사: </h5>
            <h5 class="card-title">상담일: </h5>
            <router-link to="counseling"><button  class="btn btn-primary">임시 버튼</button></router-link>
        </div>
    </div>
</div>
</template>

<script>
export default {
    name: "ScheduleCardPersonal",
    props: {},
    methods: {
    }

}
</script>

<style>
.card {
 text-align: left;
 
}
</style>
