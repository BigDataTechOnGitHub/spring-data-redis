/*
 * Copyright 2015-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.redis.repository.support;

import java.io.Serializable;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.repository.support.KeyValueRepositoryFactoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.parser.AbstractQueryCreator;

/**
 * Adapter for Springs {@link FactoryBean} interface to allow easy setup of {@link RedisRepositoryFactory} via Spring
 * configuration.
 * 
 * @author Christoph Strobl
 * @param <T> The repository type.
 * @param <S> The repository domain type.
 * @param <ID> The repository id type.
 * @since 1.7
 */
public class RedisRepositoryFactoryBean<T extends Repository<S, ID>, S, ID extends Serializable> extends
		KeyValueRepositoryFactoryBean<T, S, ID> {

	/*
	 * (non-Javadoc)
	 * @see org.springframework.data.keyvalue.repository.support.KeyValueRepositoryFactoryBean#createRepositoryFactory(org.springframework.data.keyvalue.core.KeyValueOperations, java.lang.Class)
	 */
	@Override
	protected RedisRepositoryFactory createRepositoryFactory(KeyValueOperations operations,
			Class<? extends AbstractQueryCreator<?, ?>> queryCreator) {
		return new RedisRepositoryFactory(operations, queryCreator);
	}
}