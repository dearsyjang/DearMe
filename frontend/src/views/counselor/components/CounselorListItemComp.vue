<template>
  <div>


    <div class="card">
      <!-- <div v-if="check(counselor)"> -->
      <router-link to="/counselors/counselor/:counselorId">
      <!-- <router-link
      :to="{ name: 'counselor', params: {counselorId: temp.id} }"> -->
        <div class="card mb-3" style="max-width: 540px;">
          <div class="row g-0">
            <div class="col-md-4">
              <img src="@/assets/사람.png" class="img-fluid rounded-start" style="width:100px;height: 100px;" alt="...">
            </div>
            <div class="col-md-8">
              <div class="card-body">
                <h5 class="card-title">{{temp.name}}</h5>
                <p class="card-text">{{temp.rating}}</p>
                <p class="card-text"><small class="text-muted">{{temp.satisfaction}}</small></p>
                <div v-if="!like">
                  <button class="btn btn-link" @click="favoriteCounselor(movieId)"><i class="fa-solid fa-heart" style="color:black"></i></button>
                </div>
                <div v-else>
                  <button class="btn btn-link" @click="favoriteCounselor(movieId)"><i class="fa-solid fa-heart" style="color:red"></i></button>
                </div>
              </div>
            </div>
          </div>
        </div>
      </router-link>
      <!-- </div> -->
    </div>
  </div>
</template>

<script>
import {  mapActions } from 'vuex'
  export default {
    name : 'CounselorItem',
    props:{
      temp:Object
    },
    methods:{
      ...mapActions(['favoriteCounselor','isFavorite']),
    }
    
  }

</script>

<style>

</style>