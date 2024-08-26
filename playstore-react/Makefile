.PHONY: genclient
genclient:
	docker run --rm -v "$(PWD):/app" -v "$(PWD)/api/spec/api-spec.yaml:/api-spec.yaml" openapitools/openapi-generator-cli:latest generate \
			-g typescript-fetch \
			-i /api-spec.yaml \
			-o /app/api/generated