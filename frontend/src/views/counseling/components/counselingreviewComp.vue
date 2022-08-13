<template>
  <div>
    <form @submit.prevent="onSubmit" class="review-list-form">
        

        <div class="star-rating space-x-4 mx-auto">
          <input type="radio" id="5-stars" name="rating" value="5" v-model="value"/>
          <label for="5-stars" class="star pr-4">★</label>
          <input type="radio" id="4-stars" name="rating" value="4" v-model="value"/>
          <label for="4-stars" class="star">★</label>
          <input type="radio" id="3-stars" name="rating" value="3" v-model="value"/>
          <label for="3-stars" class="star">★</label>
          <input type="radio" id="2-stars" name="rating" value="2" v-model="value"/>
          <label for="2-stars" class="star">★</label>
          <input type="radio" id="1-star" name="rating" value="1" v-model="value" />
          <label for="1-star" class="star">★</label>
        </div>
        
        <div class="my-3 w-100 d-flex justify-content-start align-items-center ">
          <label for="review"></label>
          <input  placeholder="평가를 50자 이내로 입력해주세요." type="text" id="review"  style="width:50%; height:25px; margin:auto" v-model="contents" required>
        </div>
        <button class="changebtn" >작성하기</button>

      </form>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'


export default {
  name : 'CounselingReviewComp',
  data() {
    return {
      counselorId: this.$route.params.counselorId,
      review : {
      contents: '',
      id: '',
      value : 0}
    }
  },
  computed : {
    ...mapGetters(['reviews'])
  },
  methods: {
    ...mapActions(['createReview']),


  onSubmit() {
    this.review = {
      id: this.counselorId,
      contents: this.contents,
      value: this.value
    }
    this.createReview(this.review)
    console.log(this.review.id)
    console.log(this.review.contents)
    console.log(this.review.value)
  }
  }

}


</script>
<style >
.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 2.25rem;
  line-height: 2.5rem;
  justify-content: space-around;
  padding: 0 0.2em;
  text-align: center;
  width: 5em;
}
 
.star-rating input {
  display: none;
}
 
.star-rating label {
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 2.3px;
  -webkit-text-stroke-color: #2b2a29;
  cursor: pointer;
}
 
.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}
 
.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
}

</style>