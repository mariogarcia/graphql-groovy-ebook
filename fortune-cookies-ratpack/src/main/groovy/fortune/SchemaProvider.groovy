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
