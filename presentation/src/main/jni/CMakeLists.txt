cmake_minimum_required(VERSION 3.4.1)

add_library(urls SHARED
            urls.c)

# Include libraries needed for urls lib
target_link_libraries(urls log android)
