<template>
    <div class="loginDiv">
        <Header :title="title"></Header>
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
import Header from './header/Header.vue'
export default {
    components: {Header},
    data: function() {
        return {
            message: 'Hello World!',
            title: '密码登录'
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


