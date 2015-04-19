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
 :emacs-eval ['(set-language-environment 'Chinese-GB)
              '(setq locale-coding-system 'utf-8)
              '(set-terminal-coding-system 'utf-8)
              '(set-keyboard-coding-system 'utf-8)
              '(set-selection-coding-system 'utf-8)
              '(prefer-coding-system 'utf-8)
              '(require 'un-define "un-define" t)
              '(set-buffer-file-coding-system 'utf-8 'utf-8-unix)
              '(set-default buffer-file-coding-system 'utf-8-unix)
              '(set-default-coding-systems 'utf-8-unix)
              '(prefer-coding-system 'utf-8-unix)
              '(set-default default-buffer-file-coding-system 'utf-8-unix)]
 :atomic-build true]

