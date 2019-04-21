<template>
    <header>
        <img src="../../../static/images/left_arrow.png" />
        <span>{{title}}</span>
    </header>
</template>

<script>
export default {
    props: ['title']
}
</script>

<style lang="scss">
    header {
        background-color: #3190e8;
        height: 30px;
        line-height: 35px;
        color: white;
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;

        img {
            width: 25px;
            position: absolute;
            left: 20px;
            top: 4px;
        }

        span {
            font-weight: bold;
        }
    }
</style>
