library(rjson)
library(tidyverse)
library(timetk)

result <- fromJSON(file = "repos.json")

foo <- function(x) x$name 

lapply(result)

data_frame <- as.data.frame(do.call(cbind, result))

names <- unlist(data_frame['name',])


df <- data_frame %>% t() %>% .[,c("name","created_at")] %>% as.data.frame()

df <- as_tibble(df) %>% unnest(cols = c(name, created_at))



df %>% filter_by_time(.date_var = created_at, .start_date = '2020-09-01', .end_date = '2021-02-01')

df <- separate(df,created_at, sep="T",into = c("date","time"))

names <- df %>% filter(date < as.Date("2021-02-01")) %>% select(name) %>% unlist() %>% paste(collapse = " ")
