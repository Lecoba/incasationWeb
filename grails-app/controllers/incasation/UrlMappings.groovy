package incasation

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller: "transaction")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
