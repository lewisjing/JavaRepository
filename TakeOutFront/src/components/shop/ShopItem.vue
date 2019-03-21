<template>
    <div class="shop-item">
        <div class="shop-icon-div">
            <img class="shop-icon" src="../../../static/images/eleme.png" />
        </div>
        <div class="shop-info">
            <div class="shop-name">阿文夜市豆浆油条店</div>
            <div class="shop-star">
                <span>4.2</span>
                <span>月售669单</span>
            </div>
            <div class="shop-money">￥0起送 / 配送费￥8</div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="scss">
    .shop-item {
        height: 80px;
        display: flex;

        .shop-icon-div {
            border: 1px solid;
            .shop-icon {
                height: 80px;
            }
        }

        .shop-info {
            display: flex;
            flex-direction: column;
            justify-content: space-between;
            padding-left: 15px;

            .shop-name {
                font-weight: bold;
            }

            .shop-star, .shop-money {
                font-size: 12px;
                color: #666;
            }

        }
    }

</style>
