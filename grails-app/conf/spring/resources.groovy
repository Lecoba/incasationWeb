import incasation.MyDateTimeConverter
import incasation.UserPasswordEncoderListener
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.servlet.i18n.SessionLocaleResolver

// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    myConverter(MyDateTimeConverter)
    localeResolver(SessionLocaleResolver) {
        defaultLocale= new Locale('arm');
    }
}
