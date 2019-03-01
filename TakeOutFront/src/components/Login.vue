<template>
    <div class="loginDiv">
        <header>
            <img src="../../static/images/left_arrow.png" />
            <span>密码登陆</span>
        </header>
        <div>
            <div class="user">
                <input name="username" type="text" placeholder="用户名"/>
            </div>
            <div class="pwd">
                <input name="password" type="password" placeholder="密码"/>
            </div>
            <div class="captcha">
                <input name="captcha" type="text" placeholder="验证码"/>
            </div>
        </div>
        <div class="tipMessage">
            <span>温馨提示:未注册饿了么账号的手机号,登陆时将自动注册,且代表您已同意
                <a href="www.baidu.com">《用户服务协议》</a>
            </span>
        </div>
        <button class="loginbtn">登录</button>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            message: 'Hello World!'
        }
    }
}
</script>

<style lang="scss">
    .loginDiv {
        padding-top: 20px;
        .loginbtn {
            margin-top: 30px;
            background-color: #4cd964;
            width: 100%;
            height: 30px;
            border-radius: 5px;
            color: white;
            border: 0px;
        }

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

        .tipMessage {
            margin-top: 20px;
            font-size: 10px;
            text-align: left;
        }

        .user, .pwd, .captcha {
            margin-top: 10px;
        }

        label {
            font-size: 16px;
        }

        input {
            border: 0px;
            width: 100%;
            height: 20px;
            outline: none;
        }
    }
</style>


