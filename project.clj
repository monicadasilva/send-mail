(defproject send-email "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [com.draines/postal "2.0.5"]]
  :main ^:skip-aot send-email.core
  :target-path "target/%s"
  :puglins [[lein-cloverage "1.2.4"]]
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true", "-Djava.net.preferIPv4Stack=true"]}
             :repl {:repl-options {:timeout 220000}}})
