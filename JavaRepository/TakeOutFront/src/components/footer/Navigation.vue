<template>
    <div class="navigation">
        <span class="navItem">
            <span><img src="../../../static/images/takeout.png" /></span>
            <span>外卖</span>
        </span>
        <span class="navItem">
            <span><img src="../../../static/images/shopping.png" /></span>
            <span>超市</span>
        </span>
        <span class="navItem">
            <span><img src="../../../static/images/order.png" /></span>
            <span>订单</span>
        </span>
        <span class="navItem">
            <span><img src="../../../static/images/personal.png" /></span>
            <span>我的</span>
        </span>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="scss">
    .navigation {
        display: flex;
        justify-content: space-around;
        .navItem {
            display: inline-flex;
            flex-direction: column;

            img {
                width: 20px;
            }
        }
    }        
</style>
