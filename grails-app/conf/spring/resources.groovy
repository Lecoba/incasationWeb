import incasation.MyDateTimeConverter
import incasation.UserPasswordEncoderListener
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    myConverter(MyDateTimeConverter)
}
