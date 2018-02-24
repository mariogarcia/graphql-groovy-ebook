import static ratpack.groovy.Groovy.ratpack

import gql.ratpack.GraphQLModule
import gql.ratpack.GraphQLHandler
import gql.ratpack.GraphiQLHandler

import graphql.schema.GraphQLSchema
import fortune.SchemaProvider

ratpack {
  bindings {
        module GraphQLModule // <1>
        providerType GraphQLSchema, SchemaProvider
  }

  handlers {
    post('graphql', GraphQLHandler) // <2>
    get('graphql/browser', GraphiQLHandler) // <3>
  }
}
