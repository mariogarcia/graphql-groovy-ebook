// tag::dummy[]
package fortune

import javax.inject.Provider
import gql.DSL
import graphql.schema.GraphQLSchema

class SchemaProvider implements Provider<GraphQLSchema> {

  @Override
  GraphQLSchema get() {
    return DSL.mergeSchemas {
      byResource('schema/Cookie.graphql')
      byResource('schema/Schema.graphql') {
        mapType('Queries') { // <1>
            link('randomCookie') { env -> // <2>
                return [author: 'Anonymous', text: "Don't talk to strangers"] // <3>
            }
        }
      }
    }
  }
}
// end::dummy[]

/**
// tag::initial[]
package fortune

import javax.inject.Provider
import gql.DSL
import graphql.schema.GraphQLSchema

class SchemaProvider implements Provider<GraphQLSchema> {

  @Override
  GraphQLSchema get() {
    return DSL.mergeSchemas {
      byResource('schema/Cookie.graphql')
      byResource('schema/Schema.graphql')
    }
  }
}
// end::initial[]
**/
