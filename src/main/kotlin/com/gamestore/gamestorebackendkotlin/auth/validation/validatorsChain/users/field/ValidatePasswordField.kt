package com.gamestore.gamestorebackendkotlin.auth.validation.validatorsChain.users.field

import com.gamestore.gamestorebackendkotlin.auth.errors.ValidationError
import com.gamestore.gamestorebackendkotlin.auth.validation.ValidationProps
import com.gamestore.gamestorebackendkotlin.auth.validation.ValidatorInterface
import org.springframework.stereotype.Component

/** Регулярки для валидации пароля
 *
 * - (?=(?:.*[a-z]){3}) // Положительный предварительный просмотр, чтобы соответствовать ровно 3 строчным буквам
 * - (?=(?:.*[A-Z]){2}) // Положительный предварительный просмотр, чтобы совпадали ровно 2 заглавные буквы
 * - (?=.*[?!@#*%^&-+]) // Положительный предварительный просмотр, соответствующий ровно 1 специальному символу
 * - (?=(?:.*\d){2}) // Положительный предварительный просмотр, соответствующий ровно 2 числам

 **/
@Component
class ValidatePasswordField : ValidatorInterface<String> {
    override fun valid(arg: String?): ValidationError? {
        val errors = mutableMapOf<String, String>()
        var err: ValidationError? = null
        if (arg == null) {
            errors["Проверка на наличие пароля"] = "Введите пароль"
            return ValidationError(ValidationProps.VALIDATION_MSG_USER, errors = errors)
        }
        if (arg.length < ValidationProps.LENGTH_PASSWORD) {
            errors["Длина пароля"] = "Пароль должен быть длинее 5 сиволов"
        }
        if (errors != emptyMap<String, String>()) {
            err = ValidationError(ValidationProps.VALIDATION_MSG_USER, errors)
        }
        return err
    }
}
