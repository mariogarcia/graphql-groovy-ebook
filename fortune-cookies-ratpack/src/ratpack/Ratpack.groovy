import static ratpack.groovy.Groovy.ratpack

// <1>
import gql.ratpack.GraphQLModule
import gql.ratpack.GraphQLHandler
import gql.ratpack.GraphiQLHandler

ratpack {
  bindings {
    module GraphQLModule // <2>
  }

  handlers {
    handlers {
        post('graphql', GraphQLHandler) // <3>
        get('graphql/browser', GraphiQLHandler) // <4>
    }
  }
}
