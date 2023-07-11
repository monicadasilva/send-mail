(ns send-email.core-test
  (:require [clojure.test :refer :all]
            [send-email.core :refer :all]
            [postal.message]
            [clojure.test :only [run-tests deftest is]]
            [clojure.java.io :as io]))


(deftest test-simple
  (let [m (str
           {:from "fee@bar.dom"
            :to "Foo Bar <foo@bar.dom>"
            :cc ["baz@bar.dom" "Quux <quux@bar.dom>"]
            :date (java.util.Date.)
            :subject "Test"
            :body "Test!"
            :charset "us-ascii"})]
    (is (= "Subject: Test" (re-find #"Subject: Test" m)))
    (is (re-find #"Cc: baz@bar.dom, Quux <quux@bar.dom>" m))
    (is (re-find #"(?i)content-type:.*us-ascii" m))))
