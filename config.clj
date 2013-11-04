[:site-title "blog.leiwang.info"
 :emacs "/usr/bin/emacs"
 :site-description "blog.leiwang.info"
 :site-url "http://blog.leiwang.info"
 :in-dir "resources/"
 :out-dir "html/"
 :default-template "default.clj"
 :encoding "UTF-8"
 :blog-as-index false
 :create-archives false
 :org-export-command (progn
                      (setq org-export-with-toc nil)
                      (org-html-export-as-html nil nil nil t nil)
                      (switch-to-buffer "*Org HTML Export*")
                      (princ (buffer-string)))
 :atomic-build true]

