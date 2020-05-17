$(function () {
    $('form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields:{



                password: {

                    validators: {

                        identical: {

                            field: 'password2',

                            message: '两次输入的密码不相符'

                        }

                    }

                },

                password2: {

                    validators: {

                        identical: {

                            field: 'password',

                            message: '两次输入的密码不相符'

                        }

                    }

                }

            }

        }

    )
})