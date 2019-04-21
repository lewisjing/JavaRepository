<template>
    <div class="food-item">
        <div class="food-img-div">
            <img class="food-img" src="../../../static/images/eleme.png" />
        </div>
        <div class="food-info">
            <div class="food-info-name">浓情香鸡翼</div>
            <div class="food-info-desc">以特选鸡翼经美味香料腌制烘烤而成，鲜嫩香滑，汁多入味</div>
            <div class="food-info-sale">月售94份 好评率85%</div>
        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="scss">
    .food-item {
        display: flex;
        .food-img-div {
            .food-img {
                width: 30px;
                height: 30px;
            }
        }

        .food-info {
            text-align: left;
            padding-left: 15px;

            .food-info-name {
                font-weight: bold;
            }

            .food-info-desc {
                font-size: 12px;
                color: #666;
                padding: 5px 0;
            }

            .food-info-sale {
                font-size: 14px
            }
        }
    }
</style>
