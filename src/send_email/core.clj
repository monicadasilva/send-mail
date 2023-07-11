(ns send-email.core
  (:gen-class)
  (:require [postal.core :refer [send-message]]
            [clojure.java.io :as io]))


;; Replace the following with your own credentials
(def email "<<yourmail@mail.com>>")
(def pass "<<yourpassword>>")

(def conn {:host "smtp.elasticemail.com"
           :user email
           :pass pass
           :port 2525})

(send-message conn
              {:from email
               :to "<<yourcontact@mail.com>>"
               :subject "A message, from the past!"
               :body [{:type "text/plain"
                       :content "Hey folks, this email was send by a clojure app!"}
                      {:type :inline
                       :content (io/file "/home/msilva/Documentos/send-email/temp/superlua.jpg")
                       :content-type "image/jpg"
                       :file-name "superlua.jpg"}
                      {:type :attachment
                       :content (io/file "/home/msilva/Documentos/send-email/temp/dummy.pdf")}]})
;; -> {:error :SUCCESS, :code 0, :message "messages sent"}
