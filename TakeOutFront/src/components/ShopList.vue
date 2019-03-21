<template>
    <div>
        <!-- <mt-swipe :auto="4000" :show-indicators="false">
            <mt-swipe-item>1</mt-swipe-item>
            <mt-swipe-item>2</mt-swipe-item>
            <mt-swipe-item>3</mt-swipe-item>
        </mt-swipe> -->
    </div>
</template>

<script>
import { Swipe, SwipeItem } from 'mint-ui';
import Vue from 'vue'

Vue.component(Swipe.name, Swipe);
Vue.component(SwipeItem.name, SwipeItem);
export default {
    data: function() {
        return {

        }
    }
}
</script>

<style lang="scss">

</style>
