<template>
    <div>
        <Header :title="title"></Header>
        <div class="person-information">
            <span class="person">
                <div class="person-photo">
                    <img src="../../static/images/order.png" />
                </div>
                <span class="person-item">
                    <span class="person-name">Lewis</span>
                    <span class="person-phone">15735104296</span>    
                </span>
            </span>
            <span>
                <img src="../../static/images/right_arrow_white.png" />
            </span>
        </div>

        <div class="person-integral">
            <span class="person-integral-item">
                <span>
                    <span class="person-integral-score person-balance">0</span>
                    元
                </span>
                <span class="person-integral-name">我的余额</span>
            </span>
            <span class="person-integral-item">
                <span>
                    <span class="person-integral-score person-discount">1</span>
                    个
                </span>
                <span class="person-integral-name">我的优惠</span>
            </span>
            <span class="person-integral-item">
                <span>
                    <span class="person-integral-score person-grade">960</span>
                    积分
                </span>
                <span class="person-integral-name">我的积分</span>
            </span>
        </div>
    </div>
</template>

<script>
import Header from './header/Header.vue'
export default {
    components: {Header},
    data: function () {
        return {
            title: '我的'
        }
    }
}
</script>

<style lang="scss">
    body {
        margin: 0;
    }

    .person-information {
        height: 80px;
        padding-top: 30px;
        display: flex;
        align-items: center;
        background-color: #3190e8;
        color: white;
        justify-content: space-between;

        .person {
            display: inline-flex;
            align-items: center;
            margin-left: 10px;
            .person-photo {
                width: 50px;
                height: 50px;
                border-radius: 50%;
                border:1px solid;
            }
        }

        img {
            width: 30px;
            height: 30px;
        }

        .person-item {
            display: inline-flex;
            flex-direction: column;
            align-items: flex-start;
            padding-left: 20px;
        }
    }

    .person-integral {
        display: flex;
        justify-content: space-around;
        padding-top: 15px;
        
        .person-integral-item {
            display: inline-flex;
            flex-direction: column;

            .person-integral-name {
                font-size: 12px;
            }

            .person-integral-score {
                font-size: 24px;
            }

            .person-balance {
                color: #f90;
            }

            .person-discount {
                color: #ff5f3e;
            }

            .person-grade {
                color: #6ac20b
            }
        }
    }
</style>
